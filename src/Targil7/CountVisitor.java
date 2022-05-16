package Targil7;

public class CountVisitor implements FileVisitor {


    @Override
    public int visit(DocxFileDetails docxFile) {
        return 1;
    }

    @Override
    public int visit(PptxFileDetails pptxFile) {
        return 1;
    }

    @Override
    public int visit(HtmlFileDetails htmlFile) {
        return 1;
    }

    @Override
    public int visit(TxtFileDetails txtFile) {
        return 1;
    }

    @Override
    public int visit(Mp3FileDetails mp3File) {
        return 1;
    }

    @Override
    public int visit(JpgFileDetails jpgFile) {
        return 1;
    }

    @Override
    public int visit(DirectoryDetails directory) { return 0;}
}
