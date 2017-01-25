  import {AnswerModel} from '../models/answer.model';
  import {DataHolder} from '../models/dataHolderQuestion.model';
  
  
  export class QuestionModel{
    constructor(
        public body: string,
        public id: number,
        public closed : boolean,
        public canAnswer: boolean,
        public answers: AnswerModel[],
        public dataHolder?:DataHolder
    ){ }
}
