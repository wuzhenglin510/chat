package com.leo.chat.util;

import com.leo.chat.proto.ChatPackOuterClass;
import com.leo.chat.proto.data.ResultOuterClass;

public class ResultUtil {

    public static ChatPackOuterClass.ChatPack buildPack(String uid, Boolean succeed) {
        return ChatPackOuterClass.ChatPack.newBuilder()
                .setType(ChatPackOuterClass.ChatPack.Type.RESULT)
                .setResult(ResultOuterClass.Result.newBuilder()
                        .setUid(uid)
                        .setSucceed(succeed))
                .build();
    }

}
