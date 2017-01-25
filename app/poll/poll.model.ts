import {AnswerModel} from "../models/answer.model";

export class PollModel{
    constructor(
        public body: string,
        public closed: boolean,
        public id: number,
        public answers: AnswerModel []
    ){ }
}
