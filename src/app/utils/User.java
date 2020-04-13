package app.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

//import javax.jws.soap.SOAPBinding.Use;

public class User {

    private int userId;
    private String email;
    private String username;
    private byte[] passwordHash;
    private String saltKey;
    private int languageId;
    private Boolean isAdmin;
    private Boolean isGuest;
    private Boolean active;
    private Boolean deleted;
    private int avatarId;

    // ctor
    User() {
    }

    User(String e, String u, String p) {
        email = e;
        username = u;

    }

    /**
     * @param userId the userId to get
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param email the email to get
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the passwordHash
     */
    public byte[] getPasswordHash() {
        return passwordHash;
    }

    /**
     * @param passwordHash the passwordHash to set
     */
    public void setPasswordHash(String p) {
        this.passwordHash = hashPassword(p);
    }

    /**
     * @return the saltKey
     */
    public String getSaltKey() {
        return saltKey;
    }

    /**
     * @param saltKey the saltKey to set
     */
    public void setSaltKey(String saltKey) {
        this.saltKey = saltKey;
    }

    /**
     * @return the languageId
     */
    public int getLanguageId() {
        return languageId;
    }

    /**
     * @param languageId the languageId to set
     */
    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    /**
     * @return the isAdmin
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * @return the isGuest
     */
    public Boolean getIsGuest() {
        return isGuest;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @return the deleted
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * @return the avatarId
     */
    public int getAvatarId() {
        return avatarId;
    }

    public User getUserById(int id) {
        return new User();
    }

    private byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return salt;
    }

    private byte[] hashPassword(String p) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        md.update(getSalt());

        return md.digest(p.getBytes(StandardCharsets.UTF_8));
    }
}