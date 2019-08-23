package org.free.sso.framework.mybatis

import tk.mybatis.mapper.common.Mapper
import tk.mybatis.mapper.common.special.InsertListMapper

/**
 * father of all the mybatis mappers that implements single table CURD
 * @tparam T  real type relative table
 */
trait BaseMapper[T] extends Mapper[T] with InsertListMapper[T]{

}
