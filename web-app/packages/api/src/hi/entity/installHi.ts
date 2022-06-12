export class installHi{
  name:string

  constructor(name:string){
    this.name = name
  }

  public setName(name:string){
    this.name = name
  }

  public getName():string{
    return this.name;
  }

  public toString():string{
    return "InstallHi{" +
    "name='" + this.name + '\'' +
    '}';
  }
}
