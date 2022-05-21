package Targil7;

public class SizeVisitor implements FileVisitor {

    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public void visit(DocxFileDetails docxFile) {
        size += docxFile.getSize();
    }

    @Override
    public void visit(PptxFileDetails pptxFile) {
        size += pptxFile.getSize();
    }

    @Override
    public void visit(HtmlFileDetails htmlFile) {
        size += htmlFile.getSize();
    }

    @Override
    public void visit(TxtFileDetails txtFile) {
        size += txtFile.getSize();
    }

    @Override
    public void visit(Mp3FileDetails mp3File) {
        size += mp3File.getSize();
    }

    @Override
    public void visit(JpgFileDetails jpgFile) {
        size += jpgFile.getSize();
    }

    @Override
    public void visit(DirectoryDetails directory) { }
}
