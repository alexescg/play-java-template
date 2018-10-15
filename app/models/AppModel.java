package models;

import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class AppModel extends Model {

    @Id
    public Long id;

    @WhenCreated
    public Date createdAt = new Date();

    @WhenModified
    public Date updatedAt;

    @Override
    public void save() {
        if (this.id == null) {
            super.save();
            return;
        }
        this.update();
    }

}