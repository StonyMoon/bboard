package com.stonymoon.bboard.api;


import com.stonymoon.bboard.util.ResponseUtil;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;


import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


public class RankConverterFactory extends Converter.Factory {


    public static RankConverterFactory create() {
        return new RankConverterFactory();
    }


    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == List.class) {
            return new RankBodyConverter<Type>(type);
        }
        return null;

    }

    private static class RankBodyConverter<T> implements Converter<ResponseBody, T> {
        private Type type;

        RankBodyConverter(Type type) {
            this.type = type;
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            String body = value.string();
            return (T) ResponseUtil.handleRankResponse(body);

        }
    }
}