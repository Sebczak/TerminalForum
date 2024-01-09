import java.util.*;

public class PostStorage {

    private Map<Integer, Post> Posts;
    private int postCounter;
    Scanner scanner = new Scanner(System.in);

    public PostStorage() {
        this.Posts = new HashMap<>();
        this.postCounter = 1;
    }

    public Post createPost(String author) {
        System.out.print("Podaj Tytul posta: ");
        String postTitle = scanner.nextLine();
        System.out.print("Opisz temat: ");
        String postContent = scanner.nextLine();

        int postId = postCounter++;
        return new Post(postId, postTitle, postContent, author);
    }

    public void addPost(Post post) {
        Posts.put(post.getPostId(),post);
    }
    
    public Map<Integer, Post> getPosts() {
        return Posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostStorage that = (PostStorage) o;
        return Objects.equals(Posts, that.Posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Posts);
    }

    @Override
    public String toString() {
        return "PostStorage{" +
                "Posts=" + Posts +
                '}';
    }
}
