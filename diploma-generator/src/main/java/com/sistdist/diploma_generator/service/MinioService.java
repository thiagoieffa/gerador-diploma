package com.sistdist.diploma_generator.service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class MinioService {

    private MinioClient minioClient;

    @Value("${minio.bucket.name}")
    private String bucket;

    public MinioService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public void subirPdf(byte[] fileBytes, String nomeArquivo) throws IOException {
        try {
            // Verificar se o bucket existe
            boolean existeBucket = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
            if (!existeBucket) {
                // Se não existir, cria o bucket
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            }

            // Fazer upload do arquivo PDF
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucket)                     // Nome do bucket
                    .object(nomeArquivo)                   // Nome do arquivo no MinIO
                    .stream(new ByteArrayInputStream(fileBytes), fileBytes.length, -1) // Conteúdo do arquivo
                    .build());           // Tamanho do arquivo

        } catch (MinioException e) {
            throw new IOException("Erro ao conectar ao MinIO ou fazer upload", e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
