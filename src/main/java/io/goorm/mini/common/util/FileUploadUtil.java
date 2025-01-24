package io.goorm.mini.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileUploadUtil {

    private static String uploadDir;

    // application.properties에서 file.upload-dir 값 읽어오기
    @Value("${file.upload-dir}")
    public void setUploadDir(String uploadDir) {
        FileUploadUtil.uploadDir = uploadDir;
    }

    public static String uploadFile(MultipartFile file, String subDir) {
        // 서브 디렉토리 포함 경로 설정
        String fullPath = uploadDir + "/" + subDir;
        File dir = new File(fullPath);

        // 디렉토리가 없으면 생성
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 랜덤 파일명 생성
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uniqueFilename = UUID.randomUUID().toString() + fileExtension;

        // 파일 저장
        try {
            Path filePath = Paths.get(fullPath, uniqueFilename);
            file.transferTo(filePath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류가 발생했습니다: " + originalFilename, e);
        }

        // 저장된 파일의 경로 반환 (웹 경로 기준)
        return "/upload/" + subDir + "/" + uniqueFilename;
    }
}


