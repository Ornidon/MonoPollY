  import {StatsAnswer} from '../models/statisticalAnswer.model';
  
  export class StatsQuestionModel{
    constructor(
        public body: string,
        public id: number,
        public closed : boolean,
        public answers: StatsAnswer[]
    ){ }
}
