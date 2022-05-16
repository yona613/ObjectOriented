package Targil7;

public interface FileVisitor{

    public int visit(DocxFileDetails docxFile);
    public int visit(PptxFileDetails pptxFile);
    public int visit(HtmlFileDetails htmlFile);
    public int visit(TxtFileDetails txtFile);
    public int visit(Mp3FileDetails mp3File);
    public int visit(JpgFileDetails jpgFile);
    public int visit(DirectoryDetails directory);
}