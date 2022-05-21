package Targil7;

public class StatisticVisitor implements FileVisitor {

    @Override
    public void visit(DocxFileDetails docxFile) {
        System.out.println("The file " + docxFile.name + " has an average of " + Math.round((float)docxFile.getWords() / (float)docxFile.getPages()) + " words per page.");
    }

    @Override
    public void visit(PptxFileDetails pptxFile) {
        System.out.println("The average slide size in Presentation " + pptxFile.name + " is " + Math.round((float)pptxFile.getSize() / (float)pptxFile.getSlides()) + ".");
    }

    @Override
    public void visit(HtmlFileDetails htmlFile) {
        System.out.println("The file " + htmlFile.name + " contains " + htmlFile.getLines() + " lines.");
    }

    @Override
    public void visit(TxtFileDetails txtFile) {
        System.out.println("The file " + txtFile.name + " contains " + txtFile.getWords() + " words.");
    }

    @Override
    public void visit(Mp3FileDetails mp3File) {
        System.out.println("The bitrate of " + mp3File.name + " is " + mp3File.getSize() / mp3File.getLengthSec() + " bytes per second.");
    }

    @Override
    public void visit(JpgFileDetails jpgFile) {
        System.out.println("The picture " + jpgFile.name + " has an average of " + Math.round((float)jpgFile.getSize() / ((float)jpgFile.getHeight() * (float)jpgFile.getWidth()))  + " bytes per pixel.");}

    @Override
    public void visit(DirectoryDetails directory) {
        CountVisitor count = new CountVisitor();
        directory.accept(count);
        System.out.println("Directory " + directory.name + " has "+ count.getCount() + " files.");
    }
}