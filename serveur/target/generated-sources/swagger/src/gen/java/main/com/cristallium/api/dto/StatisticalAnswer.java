package com.cristallium.api.dto;

import java.util.Objects;
import com.cristallium.api.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * StatisticalAnswer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T16:05:49.733+01:00")

public class StatisticalAnswer   {
  private Long id = null;

  private String body = null;

  private List<UserDTO> users = new ArrayList<UserDTO>();

  private Boolean isValid = null;

  public StatisticalAnswer id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public StatisticalAnswer body(String body) {
    this.body = body;
    return this;
  }

   /**
   * Get body
   * @return body
  **/
  @ApiModelProperty(required = true, value = "")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public StatisticalAnswer users(List<UserDTO> users) {
    this.users = users;
    return this;
  }

  public StatisticalAnswer addUsersItem(UserDTO usersItem) {
    this.users.add(usersItem);
    return this;
  }

   /**
   * Get users
   * @return users
  **/
  @ApiModelProperty(required = true, value = "")
  public List<UserDTO> getUsers() {
    return users;
  }

  public void setUsers(List<UserDTO> users) {
    this.users = users;
  }

  public StatisticalAnswer isValid(Boolean isValid) {
    this.isValid = isValid;
    return this;
  }

   /**
   * Get isValid
   * @return isValid
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean getIsValid() {
    return isValid;
  }

  public void setIsValid(Boolean isValid) {
    this.isValid = isValid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatisticalAnswer statisticalAnswer = (StatisticalAnswer) o;
    return Objects.equals(this.id, statisticalAnswer.id) &&
        Objects.equals(this.body, statisticalAnswer.body) &&
        Objects.equals(this.users, statisticalAnswer.users) &&
        Objects.equals(this.isValid, statisticalAnswer.isValid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, body, users, isValid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatisticalAnswer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    isValid: ").append(toIndentedString(isValid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

