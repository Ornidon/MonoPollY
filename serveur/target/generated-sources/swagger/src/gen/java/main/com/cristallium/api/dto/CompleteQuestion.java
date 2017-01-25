package com.cristallium.api.dto;

import java.util.Objects;
import com.cristallium.api.dto.CompleteAsnwer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * CompleteQuestion
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T16:05:49.733+01:00")

public class CompleteQuestion   {
  private Long id = null;

  private String body = null;

  private List<CompleteAsnwer> answers = new ArrayList<CompleteAsnwer>();

  private Boolean closed = null;

  private Boolean canAnswer = null;

  public CompleteQuestion id(Long id) {
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

  public CompleteQuestion body(String body) {
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

  public CompleteQuestion answers(List<CompleteAsnwer> answers) {
    this.answers = answers;
    return this;
  }

  public CompleteQuestion addAnswersItem(CompleteAsnwer answersItem) {
    this.answers.add(answersItem);
    return this;
  }

   /**
   * Get answers
   * @return answers
  **/
  @ApiModelProperty(required = true, value = "")
  public List<CompleteAsnwer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<CompleteAsnwer> answers) {
    this.answers = answers;
  }

  public CompleteQuestion closed(Boolean closed) {
    this.closed = closed;
    return this;
  }

   /**
   * Get closed
   * @return closed
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean getClosed() {
    return closed;
  }

  public void setClosed(Boolean closed) {
    this.closed = closed;
  }

  public CompleteQuestion canAnswer(Boolean canAnswer) {
    this.canAnswer = canAnswer;
    return this;
  }

   /**
   * Get canAnswer
   * @return canAnswer
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean getCanAnswer() {
    return canAnswer;
  }

  public void setCanAnswer(Boolean canAnswer) {
    this.canAnswer = canAnswer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteQuestion completeQuestion = (CompleteQuestion) o;
    return Objects.equals(this.id, completeQuestion.id) &&
        Objects.equals(this.body, completeQuestion.body) &&
        Objects.equals(this.answers, completeQuestion.answers) &&
        Objects.equals(this.closed, completeQuestion.closed) &&
        Objects.equals(this.canAnswer, completeQuestion.canAnswer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, body, answers, closed, canAnswer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteQuestion {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
    sb.append("    closed: ").append(toIndentedString(closed)).append("\n");
    sb.append("    canAnswer: ").append(toIndentedString(canAnswer)).append("\n");
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

