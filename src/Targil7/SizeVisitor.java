package Targil7;

public class SizeVisitor implements FileVisitor {


    @Override
    public int visit(DocxFileDetails docxFile) {
        return docxFile.getSize();
    }

    @Override
    public int visit(PptxFileDetails pptxFile) {return pptxFile.getSize();}

    @Override
    public int visit(HtmlFileDetails htmlFile) {
        return htmlFile.getSize();
    }

    @Override
    public int visit(TxtFileDetails txtFile) {
        return txtFile.getSize();
    }

    @Override
    public int visit(Mp3FileDetails mp3File) {
        return mp3File.getSize();
    }

    @Override
    public int visit(JpgFileDetails jpgFile) {
        return jpgFile.getSize();
    }

    @Override
    public int visit(DirectoryDetails directory) {
        return 0;
    }
}
