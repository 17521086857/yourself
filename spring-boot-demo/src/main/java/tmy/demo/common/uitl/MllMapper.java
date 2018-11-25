package tmy.demo.common.uitl;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zhaihui
 * @date 2018/1/29
 */
public interface MllMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
