package com.example.demo;

import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

//immediate: This helps in preparing the authentication token for redirection.
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {
}

