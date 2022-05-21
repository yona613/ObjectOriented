package Targil7;

public interface FileVisitor{

    public void visit(DocxFileDetails docxFile);
    public void visit(PptxFileDetails pptxFile);
    public void visit(HtmlFileDetails htmlFile);
    public void visit(TxtFileDetails txtFile);
    public void visit(Mp3FileDetails mp3File);
    public void visit(JpgFileDetails jpgFile);
    public void visit(DirectoryDetails directory);
}