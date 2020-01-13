FROM nginx:alpine

ENV LISTEN_PORT=8888 \
    FRONTEND_ADDRESS="host.docker.internal:4210" \
    DOLLAR="$"

COPY nginx_template.conf /etc/nginx/nginx.tmpl
CMD /bin/sh -c "envsubst < /etc/nginx/nginx.tmpl > /etc/nginx/nginx.conf && nginx -g 'daemon off;' || cat /etc/nginx/nginx.conf"

