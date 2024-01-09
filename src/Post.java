public class Post {

    private String postTitle;
    private String postContent;
    private String postAuthor;
    private int postId;

    public Post(int postId, String postTitle, String postContent, String postAuthor) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postAuthor = postAuthor;
    }

    public int getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getPostAuthor() {
        return postAuthor;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Index: " + getPostId() + '\'' +
                " postTitle='" + getPostTitle() + '\'' +
                ", postContent='" + getPostContent() + '\'' +
                ", postAuthor='" + getPostAuthor() + '\'' +
                '}';
    }
}
