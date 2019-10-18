package org.zongf.base.utils.validator.util;

import org.zongf.base.utils.validator.model.IllegalConstraint;

import java.util.List;

/** 违约字段工具类
 * @author zongf
 * @date 2019-10-18
 */
public class IllegalConstraintUtil {

    /** 获取所有违约信息
     * @param illegalConstraints 违约描述列表
     * @return String
     * @since 1.0
     * @author zongf
     * @created 2019-10-18
     */
    public static String getMessages(List<IllegalConstraint> illegalConstraints) {
        if (illegalConstraints == null || illegalConstraints.size() == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        for (IllegalConstraint illegalConstraint : illegalConstraints) {
            sb.append(illegalConstraint.getPropertyName()).append(":")
                    .append(illegalConstraint.getMessage()).append("\n");
        }
        return sb.toString();
    }

}