package br.com.automation.APIRest;

/**
 * This class implements the Comment object
 * 
 * @author mariaisabel
 *
 */
public class Comment {

	private String postId;
	private String id;
	private String name;
	private String email;
	private String body;

	/**
	 * Class constructor
	 */
	public Comment() {
	}

	/**
	 * Returns the comment post ID
	 * 
	 * @return the post Id
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Register the comment regarding the post Id
	 * 
	 * @param postId
	 *            the string regarding the post Id
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}

	/**
	 * Returns the comment id
	 * 
	 * @return the comment id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the comment id
	 * 
	 * @param id
	 *            the id of the comment
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the name
	 * 
	 * @return the comment name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the comment name
	 * 
	 * @param name
	 *            the string regarding the comment name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the comment email
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Register the comment email
	 * 
	 * @param email
	 *            string regarding the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the comment body
	 * 
	 * @return the body value
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Set the comment body
	 * 
	 * @param body
	 *            the string regarding the comment body
	 */
	public void setBody(String body) {
		this.body = body;
	}

}
