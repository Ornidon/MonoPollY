package com.cristallium.api.dto;

import java.util.Objects;
import com.cristallium.api.dto.CompleteQuestion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * CompleteRoom
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T16:05:49.733+01:00")

public class CompleteRoom   {
  private Long id = null;

  private Long owner = null;

  private String name = null;

  private List<CompleteQuestion> questions = new ArrayList<CompleteQuestion>();

  public CompleteRoom id(Long id) {
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

  public CompleteRoom owner(Long owner) {
    this.owner = owner;
    return this;
  }

   /**
   * Get owner
   * @return owner
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getOwner() {
    return owner;
  }

  public void setOwner(Long owner) {
    this.owner = owner;
  }

  public CompleteRoom name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CompleteRoom questions(List<CompleteQuestion> questions) {
    this.questions = questions;
    return this;
  }

  public CompleteRoom addQuestionsItem(CompleteQuestion questionsItem) {
    this.questions.add(questionsItem);
    return this;
  }

   /**
   * Get questions
   * @return questions
  **/
  @ApiModelProperty(required = true, value = "")
  public List<CompleteQuestion> getQuestions() {
    return questions;
  }

  public void setQuestions(List<CompleteQuestion> questions) {
    this.questions = questions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteRoom completeRoom = (CompleteRoom) o;
    return Objects.equals(this.id, completeRoom.id) &&
        Objects.equals(this.owner, completeRoom.owner) &&
        Objects.equals(this.name, completeRoom.name) &&
        Objects.equals(this.questions, completeRoom.questions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, owner, name, questions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteRoom {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    questions: ").append(toIndentedString(questions)).append("\n");
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

