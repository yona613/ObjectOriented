package Targil7;

import java.util.ArrayList;
import java.util.List;

public class DirectoryDetails extends FileDetails {
    public DirectoryDetails(String path, String name){
        super(path,name);
    }
    private List<FileDetails> directoryFiles = new ArrayList<>();

    @Override
    public void accept(FileVisitor visitor) {
        for (FileDetails file : directoryFiles) {
            file.accept(visitor);
        }
        visitor.visit(this);
    }

    public void addFile(FileDetails fileDetails){
        this.directoryFiles.add(fileDetails);
    }
}