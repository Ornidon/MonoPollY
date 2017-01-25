import { UserModel } from '../user/user.model'

  export class StatsAnswer{
    constructor(
        public body: string,
        public id: number,
        public isValid: boolean,
        public users: UserModel[]
    ){ }
}
