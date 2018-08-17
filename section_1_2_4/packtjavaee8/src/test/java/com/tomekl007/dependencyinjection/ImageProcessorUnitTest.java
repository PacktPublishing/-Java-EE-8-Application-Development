package com.tomekl007.dependencyinjection;


import com.tomekl007.di.imagefileeditors.PngFileEditor;
import com.tomekl007.di.imagefileprocessor.ImageFileProcessor;
import com.tomekl007.di.loggers.TimeLogger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ImageProcessorUnitTest {
    
    private static ImageFileProcessor imageFileProcessor;
    private static SimpleDateFormat dateFormat;
    private static Calendar calendar;
    
    
    @BeforeClass
    public static void setImageProcessorInstance() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        imageFileProcessor = container.select(ImageFileProcessor.class).get();
        container.shutdown();
    }
    
    @BeforeClass
    public static void setSimpleDateFormatInstance() {
        dateFormat = new SimpleDateFormat("HH:mm");
    }
    
    @BeforeClass
    public static void setCalendarInstance() {
        calendar = Calendar.getInstance();
    }
    
    @Test
    public void givenImageProcessorInstance_whenInjectedPngFileEditorandTimeLoggerInstances_thenTwoAssertions() {
        assertThat(imageFileProcessor.getImageFileditor()).isInstanceOf(PngFileEditor.class);
        assertThat(imageFileProcessor.getTimeLogger()).isInstanceOf(TimeLogger.class);
    }
    
    @Test
    public void givenImageProcessorInstance_whenCalledopenFile_thenOneAssertion() {
        String currentTime = dateFormat.format(calendar.getTime());
        assertThat(imageFileProcessor.openFile("file1.png")).isEqualTo("Opening PNG file file1.png at: " + currentTime);
    }
    
    @Test
    public void givenImageProcessorInstance_whenCallededitFile_thenOneAssertion() {
        String currentTime = dateFormat.format(calendar.getTime());
        assertThat(imageFileProcessor.editFile("file1.png")).isEqualTo("Editing PNG file file1.png at: " + currentTime);
    }
    
    @Test
    public void givenImageProcessorInstance_whenCalledwriteFile_thenOneAssertion() {
        String currentTime = dateFormat.format(calendar.getTime());
        assertThat(imageFileProcessor.writeFile("file1.png")).isEqualTo("Writing PNG file file1.png at: " + currentTime);
    }
    
    @Test
    public void givenImageProcessorInstance_whenCalledsaveFile_thenOneAssertion() {
        String currentTime = dateFormat.format(calendar.getTime());
        assertThat(imageFileProcessor.saveFile("file1.png")).isEqualTo("Saving PNG file file1.png at: " + currentTime);
    }
}