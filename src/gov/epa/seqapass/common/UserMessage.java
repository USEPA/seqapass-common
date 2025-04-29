package gov.epa.seqapass.common;

public class UserMessage {

  private String loginPreBlockMsg;
  private String loginPostBlockMsg;
  private String submitPreBlockMsg;
  private String submitPostBlockMsg;
  private Long loginBlockTime;
  private Long submitBlockTime;
  private int id;

  public UserMessage() {
  }

  public UserMessage(String loginPreBlockMsg, String loginPostBlockMsg, String submitPreBlockMsg,
      String submitPostBlockMsg, Long loginBlockTime, Long submitBlockTime, int id) {
    this.loginPreBlockMsg = loginPreBlockMsg;
    this.loginPostBlockMsg = loginPostBlockMsg;
    this.submitPreBlockMsg = submitPreBlockMsg;
    this.submitPostBlockMsg = submitPostBlockMsg;
    this.loginBlockTime = loginBlockTime;
    this.submitBlockTime = submitBlockTime;
    this.id = id;
  }

  public static UserMessage newInstance(UserMessage orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    UserMessage copy = new UserMessage();
    copy.setLoginPreBlockMsg(orig.getLoginPreBlockMsg());
    copy.setLoginPostBlockMsg(orig.getLoginPostBlockMsg());
    copy.setSubmitPreBlockMsg(orig.getSubmitPreBlockMsg());
    copy.setSubmitPostBlockMsg(orig.getSubmitPostBlockMsg());
    copy.setLoginBlockTime(orig.getLoginBlockTime());
    copy.setSubmitBlockTime(orig.getSubmitBlockTime());
    copy.setId(orig.getId());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((loginPreBlockMsg == null) ? 0 : loginPreBlockMsg.hashCode());
    result = prime * result + ((loginPostBlockMsg == null) ? 0 : loginPostBlockMsg.hashCode());
    result = prime * result + ((submitPreBlockMsg == null) ? 0 : submitPreBlockMsg.hashCode());
    result = prime * result + ((submitPostBlockMsg == null) ? 0 : submitPostBlockMsg.hashCode());
    result = prime * result + loginBlockTime.hashCode();
    result = prime * result + submitBlockTime.hashCode();
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserMessage other = (UserMessage) obj;
    if (loginPreBlockMsg == null) {
      if (other.loginPreBlockMsg != null)
        return false;
    } else if (!loginPreBlockMsg.equals(other.loginPreBlockMsg))
      return false;
    if (loginPostBlockMsg == null) {
      if (other.loginPostBlockMsg != null)
        return false;
    } else if (!loginPostBlockMsg.equals(other.loginPostBlockMsg))
      return false;
    if (submitPreBlockMsg == null) {
      if (other.submitPreBlockMsg != null)
        return false;
    } else if (!submitPreBlockMsg.equals(other.submitPreBlockMsg))
      return false;
    if (submitPostBlockMsg == null) {
      if (other.submitPostBlockMsg != null)
        return false;
    } else if (!submitPostBlockMsg.equals(other.submitPostBlockMsg))
      return false;
    if (loginBlockTime != other.loginBlockTime)
      return false;
    if (submitBlockTime != other.submitBlockTime)
      return false;
    if (id != other.id)
      return false;
    return true;
  }

  public String getLoginPreBlockMsg() {
    return loginPreBlockMsg;
  }

  public void setLoginPreBlockMsg(String loginPreBlockMsg) {
    this.loginPreBlockMsg = loginPreBlockMsg;
  }

  public String getLoginPostBlockMsg() {
    return loginPostBlockMsg;
  }

  public void setLoginPostBlockMsg(String loginPostBlockMsg) {
    this.loginPostBlockMsg = loginPostBlockMsg;
  }

  public String getSubmitPreBlockMsg() {
    return submitPreBlockMsg;
  }

  public void setSubmitPreBlockMsg(String submitPreBlockMsg) {
    this.submitPreBlockMsg = submitPreBlockMsg;
  }

  public String getSubmitPostBlockMsg() {
    return submitPostBlockMsg;
  }

  public void setSubmitPostBlockMsg(String submitPostBlockMsg) {
    this.submitPostBlockMsg = submitPostBlockMsg;
  }

  public Long getLoginBlockTime() {
    return loginBlockTime;
  }

  public void setLoginBlockTime(Long loginBlockTime) {
    this.loginBlockTime = loginBlockTime;
  }

  public Long getSubmitBlockTime() {
    return submitBlockTime;
  }

  public void setSubmitBlockTime(Long submitBlockTime) {
    this.submitBlockTime = submitBlockTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
