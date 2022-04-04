package vttp2022paf.day1.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Comment {

    private String commentid;
    private  String user;
    private Integer rating;
    private String comment;

    public String getCommentid() {
        return commentid;
    }
    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public static Comment create(SqlRowSet rs){
        
        Comment comment = new Comment();
        comment.setCommentid(rs.getString("c_id"));
        comment.setUser(rs.getString("user"));
        comment.setRating(rs.getInt("rating"));
        comment.setComment(rs.getString("c_text"));

        return comment;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
            .add("commentid",getCommentid())
            .add("user",getUser())
            .add("rating",getRating())
            .add("comment",getComment())
            .build();
    }
    
}
