package domain.Pojos;

public class PojoArcentry {
    private String id;
    private String title;
    private String created;
    private String lastChange;
    private PojoArcentryUser pojoArcentryUser;
    private PojoArcentryFolder pojoArcentryFolder;

    private class PojoArcentryFolder {

        private String id;
        private String title;
    }

    private class PojoArcentryUser {

        private String id;
        private String email;

    }


    public PojoArcentryUser getPojoArcentryUser() {
        return pojoArcentryUser;
    }

    public void setPojoArcentryUser(PojoArcentryUser pojoArcentryUser) {
        this.pojoArcentryUser = pojoArcentryUser;
    }

    public PojoArcentryFolder getPojoArcentryFolder() {
        return pojoArcentryFolder;
    }

    public void setPojoArcentryFolder(PojoArcentryFolder pojoArcentryFolder) {
        this.pojoArcentryFolder = pojoArcentryFolder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }


}
