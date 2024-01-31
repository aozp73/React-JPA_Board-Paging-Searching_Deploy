FROM node:alpine as build
WORKDIR /app
COPY package.json /app
RUN npm install --silent
COPY . /app
RUN npm run build

FROM nginx
COPY --from=build  /app/build /usr/share/nginx/html
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf
ENTRYPOINT ["nginx", "-g", "daemon off;"]


### node Server ###
# FROM node:14-alpine

# WORKDIR /home/node/app

# COPY package*.json ./

# RUN npm cache clean --force
# RUN npm install

# COPY . .

# EXPOSE 3000

# CMD ["npm", "start"]