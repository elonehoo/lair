# Getting Started

This section will take you quickly to get started and understand how the project works as a whole and how it works.

## Step.1: Clone the project

First use degit to download the project.

```bash
npx degit elonehoo/static my-static-app
```

Use your favorite tool to open the 「app」 directory and the 「web-app」 directory respectively.

## Step.2: Install dependency

Execute in the 「app」 directory

```bash
mvn dependency:copy-dependencies
```

Execute in the 「web-app」 directory

```bash
pnpm install
```

## Step.3: Run the App

First start the SpringBoot project, first use the IDE to start the 「core」 module

```bash
mvn spring-boot:run
```

Then start the front-end project

```bash
pnpm run dev
```
