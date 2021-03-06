package com.employeepayroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/**
 * @description create Class for Defining the NIOFileAPITest
 *
 */
public class NIOFileAPITest {
    //Variables
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";
    /**
     * @description create Method for Checking the Directory Exists or Not. If exists Delete the
     *              Directory and again Creating directory. In Directory Creating Files in Range
     *              and Printing the Path of Directory and Files.
     */
    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        //Check File Exists
        Path homePath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homePath));

        //Delete Files and Check File Not Exists
        Path playPath = Paths.get(HOME +"/"+ PLAY_WITH_NIO);
        if (Files.exists(playPath))
            FileUtils.deleteFiles(playPath.toFile());
        Assertions.assertTrue(Files.notExists(playPath));

        //Create Directory
        Files.createDirectory(playPath);
        Assertions.assertTrue(Files.exists(playPath));

        //Create Files
        IntStream.range(1,10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" +cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try { Files.createFile(tempFile); }
            catch (IOException e) {}
            Assertions.assertTrue(Files.exists(tempFile));
        });

        //List Files, Directories as well as Files With Extension
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath,path -> path.toFile().isFile() &&
                                                  path.toString().startsWith("temp"))
                .forEach(System.out::println);
    }
    /**
     * @description Create Method for Watching the Service to Watch Particular directory along with
     *               all files and sub Directories
     */
    @Test
    public void givenADirectoryWhenMatchedListsAllTheActivities() throws IOException {
        Path dir = Paths.get(HOME +"/"+ PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new Java8WatchServiceExample(dir).processEvents();
    }
}
