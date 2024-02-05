package HW42.Database.Schema.Management.HW42.Database.Schema.Management.controller;


import hogwarts.HW41.SQL.and.Paging.Hogwarts.model.Avatar;
import hogwarts.HW41.SQL.and.Paging.Hogwarts.service.AvatarService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@RestController
@RequestMapping("avatar")

public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @PostMapping(value = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(@PathVariable Long id, @RequestParam MultipartFile image) throws IOException {
        if (image.getSize() >= 1024 * 300) {
            return ResponseEntity.badRequest().body("The size of your file is big to upload");
        }
        avatarService.uploadImage(id, image);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{studentId}/avatar-preview")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long studentId) {
        Avatar avatar = avatarService.findAvatarById(studentId);
        if (avatar == null) {
            avatar = new Avatar();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getData().length);


        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());

    }

    @GetMapping(value = "/{studentId}/image-from-file")
    public void downloadAvatar(@PathVariable Long studentId, HttpServletResponse response) throws IOException {
        Avatar avatar = avatarService.findAvatarById(studentId);
        if (avatar == null) {
            avatar = new Avatar();

            Path path = Path.of(avatar.getFilePath());

            try (InputStream is = Files.newInputStream(path);
                 OutputStream os = response.getOutputStream();) {
                response.setStatus(200);
                response.setContentType(avatar.getMediaType());
                response.setContentLength((int) avatar.getFileSize());
                is.transferTo(os);
            }
        }
    }

        @GetMapping
        public ResponseEntity<List<Avatar>> sortAvatarByPages (@RequestParam("page") Integer pageNumber,
                @RequestParam("size") Integer pageSize){
            List<Avatar> avatars = avatarService.getAllAvatars(pageNumber, pageSize);
            return ResponseEntity.ok(avatars);

        }
    }
