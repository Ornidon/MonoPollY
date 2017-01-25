export class AuthModel {
  constructor(
    public token: string,
    public subOjbectId: number,
    public subscribe: boolean
  ) {  }
}