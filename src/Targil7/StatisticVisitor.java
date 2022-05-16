package Targil7;

public class StatisticVisitor implements FileVisitor {


    @Override
    public int visit(DocxFileDetails docxFile) {
        System.out.println("The file " + docxFile.name + " has an average of " + Math.round((float)docxFile.getWords() / (float)docxFile.getPages()) + " words per page.");
        return 0;
    }

    @Override
    public int visit(PptxFileDetails pptxFile) {
        System.out.println("The average slide size in Presentation " + pptxFile.name + " is " + Math.round((float)pptxFile.getSize() / (float)pptxFile.getSlides()) + ".");
        return 0;
    }

    @Override
    public int visit(HtmlFileDetails htmlFile) {
        System.out.println("The file " + htmlFile.name + " contains " + htmlFile.getLines() + " lines.");
        return 0;
    }

    @Override
    public int visit(TxtFileDetails txtFile) {
        System.out.println("The file " + txtFile.name + " contains " + txtFile.getWords() + " words.");
        return 0;
    }

    @Override
    public int visit(Mp3FileDetails mp3File) {
        System.out.println("The bitrate of " + mp3File.name + " is " + mp3File.getSize() / mp3File.getLengthSec() + " bytes per second.");
        return 0;
    }

    @Override
    public int visit(JpgFileDetails jpgFile) {
        System.out.println("The picture " + jpgFile.name + " has an average of " + Math.round((float)jpgFile.getSize() / ((float)jpgFile.getHeight() * (float)jpgFile.getWidth()))  + " bytes per pixel.");
        return 0;
    }

    @Override
    public int visit(DirectoryDetails directory) {
        System.out.println("Directory " + directory.name + " has "+ directory.accept(new CountVisitor()) + " files.");
        return 0;
    }
}