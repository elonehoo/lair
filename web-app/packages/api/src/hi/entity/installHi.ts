/**
 * The inserted entity class can be synchronized with the backend
 *
 * property with name
 *
 * @author Elone Hoo <huchengyea@163.com>
 * @since 2022-06-13
 */
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
