package org.free.sso.framework.mybatis

import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired

/**
 * baseService of jdbc,implements base CRUD operations
 * @author maheng
 */
trait BaseService[T] {

  protected val logger = LoggerFactory.getLogger(this.getClass)

  @Autowired
  var mapper:BaseMapper[T] = _

  /**
   * select by primary key
   * @param id  primary key
   * @return  the data of id
   */
  def selectByPrimaryKey(id:Any) : T = {
    mapper.selectByPrimaryKey(id)
  }

  /**
   * select by equals conditions
   * @param record  conditions
   * @return  list of data
   */
  def select(record: T):java.util.List[T]  = {
    mapper.select(record)
  }

  /**
   * insert by selective
   * @param record  the data to insert
   * @return  1 if success,id if the id generate strategy is auto_increment
   */
  def insertSelective(record:T) : Int = {
    mapper.insertSelective(record)
  }

  /**
   * update the columns of non null by primary key
   * @param record  primary key and columns to update
   * @return  1 if success
   */
  def updateByPrimaryKeySelective(record:T) : Int = {
    mapper.updateByPrimaryKeySelective(record)
  }

  /**
   * delete by primary key
   * @param id primary key
   * @return  1 if success
   */
  def deleteByPrimaryKey(id:Any) : Int = {
    mapper.deleteByPrimaryKey(id)
  }
}
