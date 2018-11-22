package com.sawdevelopment.interview.questions.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import static com.google.common.io.ByteStreams.copy;

public final class CompressionUtil {
  private static final int COMPRESSION_FACTOR = 8;

  static public byte[] compressAndBase64Encode(String stringToCompress, String errorMsgPrefix) {
    byte[] compressedBytes = compress(stringToCompress.getBytes(), errorMsgPrefix);
    return Base64.getEncoder().encode(compressedBytes);
  }

  @SuppressWarnings("WeakerAccess")
  static public byte[] compress(byte[] data, String errorMsgPrefix)  {
    byte[] compressed;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(Math.max(data.length / COMPRESSION_FACTOR, 512));
    try {
      try (GZIPOutputStream gzip = new GZIPOutputStream(outputStream)) {
        gzip.write(data);
      }
      // gzip needs to be closed before accessing outputStream
      compressed = outputStream.toByteArray();
    }
    catch (IOException e) {
      e.printStackTrace();
      return new byte[0];
    }
    return compressed;
  }

  static public byte[] decompress(byte[] compressed, String errorMsgPrefix) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(compressed);
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream(Math.max(compressed.length * COMPRESSION_FACTOR, 512));
      try (GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)) {
        copy(gzipInputStream, out);
      }
      return out.toByteArray();
    }
    catch (IOException e) {
      e.printStackTrace();
      return new byte[0];
    }
  }
}
