package uz.shox.lib.service.file;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.pdfbox.debugger.ui.ImageUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import uz.shox.lib.config.ApplicationContexHolder;
import uz.shox.lib.dao.AbstractDAO;
import uz.shox.lib.dao.BookDAO;
import uz.shox.lib.dao.UploadDAO;
import uz.shox.lib.domains.Uploads;
import uz.shox.lib.dtos.uploads.UploadsDTO;
import uz.shox.lib.exception.NotFoundException;
import uz.shox.lib.service.book.BookServiceImpl;

import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 04:07 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */

public class FileStorageServiceImpl extends AbstractDAO<UploadDAO> implements FileStorageService{
        private static FileStorageServiceImpl instance;

        Path rootPath = Paths.get("/home/shoxrux/IdeaProjects/library-javaEE/upload");

    public FileStorageServiceImpl() {
        super(ApplicationContexHolder.getBean(UploadDAO.class));
    }

    public static FileStorageServiceImpl getInstance() {
            if (instance==null){
                instance = new FileStorageServiceImpl();
            }
            return instance;
    }

    @Override
    public Uploads upload(Part part) {
        try {


            String contentType = part.getContentType();
            String originalFileName = part.getSubmittedFileName();

            String replaceAll = originalFileName.replaceAll(",", "_");

            long size = part.getSize();

            String[] split = originalFileName.split("\\.");

            String fileNameExtension = split[split.length - 1];

            String generatedName = System.currentTimeMillis() + "." + fileNameExtension;

            String path = "/uploads/" + generatedName;

            Uploads uploads = Uploads.builder()
                    .contentType(contentType)
                    .originalName(originalFileName)
                    .size(size)
                    .generatedName(generatedName)
                    .path(path)
                    .build();
            dao.save(uploads);

            Path uploadsPth = rootPath.resolve(generatedName);


            Files.copy(part.getInputStream(),uploadsPth, StandardCopyOption.REPLACE_EXISTING);
            return uploads;
        }
        catch (IOException e){
            throw new RuntimeException("something wrong try again");
        }

    }

    @Override
    public File download(@NonNull String filename) {
    return null;
    }

    @Override
    public UploadsDTO get(@NonNull String fileName) {
        return null;
    }

    @Override
    public List<Uploads> getAll() {
        return null;
    }

    @Override
    public UploadsDTO getByPath(String path) throws NotFoundException {
        Optional<Uploads> byPath = dao.getByPath(path);
        if (byPath.isEmpty()){
            throw new NotFoundException("file not found");
        }

        Uploads uploads = byPath.get();
        return UploadsDTO.builder()
                .id(uploads.getId())
                .path(uploads.getPath())
                .contentType(uploads.getContentType())
                .generatedName(uploads.getGeneratedName())
                .size(uploads.getSize())
                .originalName(uploads.getOriginalName())
                .build();
    }

    @Override
    public Uploads extractCover(Part book) {
         try {
             String contentTYpe = "image/png";
             String[] split = book.getSubmittedFileName().split("\\.");
             String originalFileName = split[0] + "\\.png";
             originalFileName = originalFileName.replaceAll(",","_");

             long size = book.getSize();
             String generatedName = System.currentTimeMillis() + ".png";
             String path = "/upload/" + generatedName;

             Uploads uploads = Uploads.builder()
                     .contentType(contentTYpe)
                     .originalName(originalFileName)
                     .path(path)
                     .size(size)
                     .generatedName(generatedName)
                     .build();
             dao.save(uploads);



             String uploadPath = rootPath.resolve(generatedName).toString();

             PDDocument document = PDDocument.load(book.getInputStream());
             PDFRenderer pdfRenderer = new PDFRenderer(document);
             BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);
             ImageIOUtil.writeImage(bufferedImage,uploadPath,300);
             return uploads;
         }
         catch (IOException e){
             throw new RuntimeException("something wrong try again");
         }
    }
}
