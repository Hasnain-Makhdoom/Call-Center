package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Objects;


@Entity
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String fileType;

    @Lob
    private byte[] data;

   

    public static DBFileBuilder builder() {
        return new DBFileBuilder();
    }


    @Override
    public String toString() {
        return "File{" +
            "id=" + id +
            ", fileName=" + name +
            ", fileType=" + fileType +
            '}';
    }

    public static final class DBFileBuilder {
        private Long id;
        private String fileName;
        private String fileType;
        private byte[] data;

        private DBFileBuilder() {}

        public DBFileBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DBFileBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public DBFileBuilder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public DBFileBuilder data(byte[] data) {
            this.data = data;
            return this;
        }

        public File build() {
            File dbfile = new File();
            dbfile.setId(id);
            dbfile.setName(fileName);
            dbfile.setFileType(fileType);
            dbfile.setData(data);
            return dbfile;
        }
    }
}
