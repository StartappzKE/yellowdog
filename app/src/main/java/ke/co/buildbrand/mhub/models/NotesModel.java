package ke.co.buildbrand.mhub.models;

/**
 * Created by StartappzKE on 16-Dec-16.
 */

public class NotesModel {

    /*filename, filepath, filesize, filetype, datecreated*/
    private String filename;
    private String filepath;
    private String filesize;
    private String filetype;
    private String datecreated;



    public String getFilename() {
        return filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getFilesize() {
        return filesize;
    }

    public String getFiletype() {
        return filetype;
    }

    public String getDatecreated() {
        return datecreated;
    }


    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

}
