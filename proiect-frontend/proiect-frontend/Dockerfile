FROM node:alpine

WORKDIR /proiect-frontend

COPY . /proiect-frontend

RUN npm install -g @angular/cli

RUN npm install

CMD ["ng", "serve", "--host", "0.0.0.0"]

EXPOSE 4200




# ### STAGE 2: Run ###
# FROM nginx:1.17.1-alpine
# COPY default.conf /etc/nginx/conf.d/default.conf
# COPY --from=build /usr/src/app/dist/kanban-ui /usr/share/nginx/html
# EXPOSE 80
