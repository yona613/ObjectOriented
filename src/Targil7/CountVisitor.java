package Targil7;

public class CountVisitor implements FileVisitor {

    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void visit(DocxFileDetails docxFile) {
        count += 1;
    }

    @Override
    public void visit(PptxFileDetails pptxFile) {
        count += 1;
    }

    @Override
    public void visit(HtmlFileDetails htmlFile) {
        count += 1;
    }

    @Override
    public void visit(TxtFileDetails txtFile) {
        count += 1;
    }

    @Override
    public void visit(Mp3FileDetails mp3File) {
        count += 1;
    }

    @Override
    public void visit(JpgFileDetails jpgFile) {
        count += 1;
    }

    @Override
    public void visit(DirectoryDetails directory) { }
}
