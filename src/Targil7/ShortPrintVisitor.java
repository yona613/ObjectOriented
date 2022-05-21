package Targil7;

public class ShortPrintVisitor implements FileVisitor {


    @Override
    public void visit(DocxFileDetails docxFile) {
        System.out.println(docxFile.name);
    }

    @Override
    public void visit(PptxFileDetails pptxFile) {
        System.out.println(pptxFile.name);
    }

    @Override
    public void visit(HtmlFileDetails htmlFile) {
        System.out.println(htmlFile.name);
    }

    @Override
    public void visit(TxtFileDetails txtFile) {
        System.out.println(txtFile.name);
    }

    @Override
    public void visit(Mp3FileDetails mp3File) {
        System.out.println(mp3File.name);
    }

    @Override
    public void visit(JpgFileDetails jpgFile) {
        System.out.println(jpgFile.name);
    }

    @Override
    public void visit(DirectoryDetails directory) {
        System.out.println(directory.name);
    }
}
