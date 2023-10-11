package org.abubakarSadiq.models;

import java.util.ArrayList;
import java.util.List;

public class CompilationAlbum extends Album {
    private List<OriginalAlbum> originalAlbums;

    public CompilationAlbum(String name, String type, Artist artist) {
        super(name, type, artist);
        this.originalAlbums = new ArrayList<>();
    }

    public void addOriginalAlbum(OriginalAlbum originalAlbum) {
        originalAlbums.add(originalAlbum);
    }

    public List<OriginalAlbum> getOriginalAlbums() {
        return originalAlbums;
    }

    @Override
    public String toString() {
        return "Compilation Album: " + super.toString();
    }
}

