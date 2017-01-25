import { QuestionModel } from '../models/question.model'

export class RoomModel{
    constructor(
        public id: number,
        public owner: number,
        public name: string,
        public questions: QuestionModel[],
    ){ }

}
