package Targil7;

public class ShortPrintVisitor implements FileVisitor {


    @Override
    public int visit(DocxFileDetails docxFile) {
        System.out.println(docxFile.name);
        return 0;
    }

    @Override
    public int visit(PptxFileDetails pptxFile) {
        System.out.println(pptxFile.name);
        return 0;
    }

    @Override
    public int visit(HtmlFileDetails htmlFile) {
        System.out.println(htmlFile.name);
        return 0;
    }

    @Override
    public int visit(TxtFileDetails txtFile) {
        System.out.println(txtFile.name);
        return 0;
    }

    @Override
    public int visit(Mp3FileDetails mp3File) {
        System.out.println(mp3File.name);
        return 0;
    }

    @Override
    public int visit(JpgFileDetails jpgFile) {
        System.out.println(jpgFile.name);
        return 0;
    }

    @Override
    public int visit(DirectoryDetails directory) {
        System.out.println(directory.name);
        return 0;
    }
}
