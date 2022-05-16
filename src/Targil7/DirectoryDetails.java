package Targil7;

import java.util.ArrayList;
import java.util.List;

public class DirectoryDetails extends FileDetails {
    public DirectoryDetails(String path, String name){
        super(path,name);
    }
    private List<FileDetails> directoryFiles = new ArrayList<>();

    @Override
    public int accept(FileVisitor visitor) {
        int sum = 0;
        for (FileDetails file : directoryFiles) {
            sum += file.accept(visitor);
        }
        return sum + visitor.visit(this);
    }

    public void addFile(FileDetails fileDetails){
        this.directoryFiles.add(fileDetails);
    }
}