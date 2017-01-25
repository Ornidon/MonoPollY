package com.cristallium.api.dto;

import java.util.Objects;
import com.cristallium.api.dto.Asnwer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * Question
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T16:05:49.733+01:00")

public class Question   {
  private String body = null;

  private List<Asnwer> answers = new ArrayList<Asnwer>();

  public Question body(String body) {
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

  public Question answers(List<Asnwer> answers) {
    this.answers = answers;
    return this;
  }

  public Question addAnswersItem(Asnwer answersItem) {
    this.answers.add(answersItem);
    return this;
  }

   /**
   * Get answers
   * @return answers
  **/
  @ApiModelProperty(value = "")
  public List<Asnwer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Asnwer> answers) {
    this.answers = answers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question = (Question) o;
    return Objects.equals(this.body, question.body) &&
        Objects.equals(this.answers, question.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(body, answers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Question {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
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

