package uz.shox.lib.service.file;

import lombok.NonNull;
import uz.shox.lib.domains.Uploads;
import uz.shox.lib.dtos.uploads.UploadsDTO;
import uz.shox.lib.exception.NotFoundException;

import javax.servlet.http.Part;
import java.io.File;
import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 09/11/22 23:30 (Wednesday)
 * library-javaEE/IntelliJ IDEA
 */
public interface FileStorageService {
    Uploads upload (Part part);

    File download (@NonNull String filename);

    UploadsDTO get(@NonNull String fileName);

    List<Uploads> getAll();

    UploadsDTO getByPath(String path) throws NotFoundException;

    Uploads extractCover (Part book);
}
